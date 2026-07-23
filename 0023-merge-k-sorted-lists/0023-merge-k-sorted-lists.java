class Solution {
    public ListNode mergeKLists(ListNode[] l) {
        if (l == null || l.length == 0) return null;
        return m(l, 0, l.length - 1);
    }
    private ListNode m(ListNode[] l, int s, int e) {
        if (s == e) return l[s];
        if (s + 1 == e) return mg(l[s], l[e]);
        int mid = s + (e - s) / 2;
        return mg(m(l, s, mid), m(l, mid + 1, e));
    }
    private ListNode mg(ListNode a, ListNode b) {
        ListNode d = new ListNode(0), c = d;
        while (a != null && b != null) {
            if (a.val < b.val) { c.next = a; a = a.next; }
            else { c.next = b; b = b.next; }
            c = c.next;
        }
        c.next = (a != null) ? a : b;
        return d.next;
    }
}