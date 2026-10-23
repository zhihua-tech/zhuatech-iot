/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.iot.workbench;

import static cn.zhuatech.iot.workbench.WorkbenchInput.*;

import java.math.*;
import java.util.*;
import org.springframework.stereotype.Service;

/** 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。 */
@Service
public class AiWorkbenchService {
  /** 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。 */
  public Map<String, Object> execute(Map<String, Object> r) {
    validate(r);

    keys(r, "expectedStart", "expectedEnd", "received");
    int start = integer(r, "expectedStart", 0, 2000000000),
        end = integer(r, "expectedEnd", 0, 2000000000);
    if (start > end) throw new IllegalArgumentException("预期序号区间倒置");
    var raw = list(r, "received", 0, 500);
    TreeSet<Integer> inside = new TreeSet<>();
    Set<Integer> seen = new HashSet<>();
    List<Integer> duplicates = new ArrayList<>(), outside = new ArrayList<>();
    for (Object v : raw) {
      int n = integer(Collections.singletonMap("n", v), "n", 0, 2000000000);
      if (!seen.add(n)) {
        duplicates.add(n);
        continue;
      }
      if (n < start || n > end) outside.add(n);
      else inside.add(n);
    }
    List<Map<String, Object>> gaps = new ArrayList<>();
    long cursor = start, missing = 0;
    for (int n : inside) {
      if (n > cursor) {
        gaps.add(Map.of("from", cursor, "to", (long) n - 1, "count", n - cursor));
        missing += n - cursor;
      }
      cursor = (long) n + 1;
    }
    if (cursor <= end) {
      gaps.add(Map.of("from", cursor, "to", (long) end, "count", end - cursor + 1));
      missing += end - cursor + 1;
    }
    long expected = (long) end - start + 1;
    Collections.sort(duplicates);
    Collections.sort(outside);
    return Map.of(
        "expectedCount",
        expected,
        "receivedUniqueInRange",
        inside.size(),
        "missingCount",
        missing,
        "completenessPercent",
        round(inside.size() * 100.0 / expected),
        "gaps",
        gaps,
        "duplicates",
        duplicates,
        "outsideRange",
        outside);
  }
}
