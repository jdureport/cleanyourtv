package com.gathin.tvhome;

/**
 * Uzbek Latin to the 2026 alphabet: oʻ to ö, gʻ to ğ, sh to ş, ch to ç (any of the apostrophe forms after o/g).
 * Used for the weekday and month names Android formats for the uz locale (uz_new_alphabet).
 */
final class UzLatin {
    private UzLatin() {
    }

    static String convert(CharSequence in) {
        if (in == null) return null;
        String s = in.toString();
        StringBuilder out = new StringBuilder(s.length());
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            char next = i + 1 < n ? s.charAt(i + 1) : 0;
            if ((c == 'o' || c == 'O' || c == 'g' || c == 'G') && isApostrophe(next)) {
                out.append(c == 'o' ? 'ö' : c == 'O' ? 'Ö' : c == 'g' ? 'ğ' : 'Ğ');
                i++;
            } else if ((c == 's' || c == 'S' || c == 'c' || c == 'C') && (next == 'h' || next == 'H')) {
                boolean upper = Character.isUpperCase(c);
                char base = Character.toLowerCase(c) == 's' ? 'ş' : 'ç';
                out.append(upper ? Character.toUpperCase(base) : base);
                i++;
            } else {
                out.append(c);
            }
        }
        return out.toString();
    }

    private static boolean isApostrophe(char c) {
        return c == 'ʻ' || c == '‘' || c == '\'' || c == '’' || c == '`';
    }
}
