package com.gathin.tvhome;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class UzLatinTest {
    @Test
    public void weekdays() {
        assertEquals("duşanba", UzLatin.convert("dushanba"));
        assertEquals("seşanba", UzLatin.convert("seshanba"));
        assertEquals("çorşanba", UzLatin.convert("chorshanba"));
        assertEquals("payşanba", UzLatin.convert("payshanba"));
        assertEquals("juma", UzLatin.convert("juma"));
        assertEquals("şanba", UzLatin.convert("shanba"));
        assertEquals("yakşanba", UzLatin.convert("yakshanba"));
    }

    @Test
    public void caseAndApostrophes() {
        assertEquals("SEŞANBA 17-NOYABR", UzLatin.convert("SESHANBA 17-NOYABR"));
        assertEquals("Çorşanba", UzLatin.convert("Chorshanba"));
        assertEquals("ö ğ Ö Ğ ö", UzLatin.convert("oʻ gʻ Oʻ Gʻ o'"));
        assertEquals("bölim", UzLatin.convert("bo‘lim"));
    }

    @Test
    public void leavesOtherTextAlone() {
        assertEquals("17-noyabr", UzLatin.convert("17-noyabr"));
        assertEquals("", UzLatin.convert(""));
        assertNull(UzLatin.convert(null));
    }
}
