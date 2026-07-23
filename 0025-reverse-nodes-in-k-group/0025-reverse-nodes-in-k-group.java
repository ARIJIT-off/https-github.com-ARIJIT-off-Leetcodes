class Solution {
    public ListNode reverseKGroup(ListNode h, int k) {
        if (h == null || k == 1) return h;
        ListNode d = new ListNode(0, h), p = d, c = h, n;
        int l = 0;
        ListNode t = h;
        while (t != null) {
            l++;
            t = t.next;
        }
        for (; l >= k; l -= k) {
            for (int i = 1; i < k; i++) {
                n = c.next;
                c.next = n.next;
                n.next = p.next;
                p.next = n;
            }
            p = c;
            c = c.next;
        }
        return d.next;
    }
}