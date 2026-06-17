class Solution {
    public char processStr(String s, long k) {
        int n = s.length();

        long[] length = new long[n];
        long len = 0;

        // 각 단계의 문자열 길이 저장
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (ch == '*') {
                if (len > 0) len--;
            } else if (ch == '#') {
                len *= 2;
            } else if (ch == '%') {
            } else {
                len++;
            }

            length[i] = len;
        }

        if (k >= len) {
            return '.';
        }

        // 뒤에서부터 역추적
        for (int i = n - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            long curLen = length[i];

            if (ch >= 'a' && ch <= 'z') {

                long prevLen = curLen - 1;

                if (k == prevLen) {
                    return ch;
                }

            } else if (ch == '%') {

                k = curLen - 1 - k;

            } else if (ch == '#') {

                long prevLen = curLen / 2;

                if (prevLen > 0) {
                    k %= prevLen;
                }

            } else {

                long prevLen = curLen + 1;

                if (k == curLen) {
                    return '.';
                }
            }
        }

        return '.';
    }
}