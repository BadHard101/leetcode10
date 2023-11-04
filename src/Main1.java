public class Main1 {

    public static boolean isMatch(String s, String p) {
        int s_len = s.length();
        int p_len = p.length();

        int s_index = 0;
        int p_index = 0;

        Character cur_s;
        Character cur_p;

        while (s_index != s_len && p_index != p_len) {
            cur_s = s.charAt(s_index);
            cur_p = p.charAt(p_index);

            if (cur_p == '*') {
                p_index++;
                continue;
            }

            if (p_index+1 != p_len && p.charAt(p_index+1) == '*') {

                if (cur_p == '.'){
                    while (s_index != s_len && !cur_s.equals(p.charAt(p_index+1))) {
                        s_index++;
                        if (s_index == s_len) {
                            p_index += 2;
                            continue;
                        }
                        cur_s = s.charAt(s_index);
                    }

                } else {
                    Character cur = cur_p;
                    while (s_index != s_len && cur_s.equals(cur)) {
                        s_index++;
                        if (s_index == s_len) continue;
                        cur_s = s.charAt(s_index);
                    }
                    p_index += 2;
                    continue;
                }
            } else if (cur_p.equals('.')) {
                s_index++;
                p_index++;
                continue;
            }


            if (cur_s.equals(cur_p)) {
                s_index++;
                p_index++;
                //continue;
            }
        }

        if (p_index == p_len && s_index == s_len) return true;
        else return false;
    }

    public static void main(String[] args) {
        //System.out.println(isMatch("aab", "c*a*b"));
        //System.out.println(isMatch("aa", "a"));
        //System.out.println(isMatch("Hello World", ".el*o .*"));
        //System.out.println(isMatch("Hello World", ".el*o .*.));
    }
}