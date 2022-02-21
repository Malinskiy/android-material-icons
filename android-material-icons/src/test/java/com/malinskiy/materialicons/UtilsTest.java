package com.malinskiy.materialicons;

import org.junit.Test;

import static com.malinskiy.materialicons.Iconify.IconValue.zmdi_account_add;
import static org.junit.Assert.assertEquals;

public class UtilsTest {

    @Test
    public void test_replaceIcons() {
        test("A{zmdi-account-add}A", "A" + zmdi_account_add.character + "A");
    }

    @Test
    public void test_replaceIcons_noIcons() {
        test("A A", "A A");
    }

    @Test
    public void test_replaceIcons_manyIcons() {
        test("A{zmdi-account-add}A{zmdi-account-add}A", "A" + zmdi_account_add.character + "A" + zmdi_account_add.character + "A");
    }

    @Test
    public void test_replaceIcons_withDash() {
        test("A{zmdi-account-add}A{zmdi-account-add}A", "A" + zmdi_account_add.character + "A" + zmdi_account_add.character + "A");
    }

    @Test
    public void test_replaceIcons_wrong() {
        test("A{icon-okA{icon-camera}A", "A{icon-okA{icon-camera}A");
    }

    @Test
    public void test_replaceIcons_empty() {
        test("A{}A", "A{}A");
    }

    private void test(String in, String out) {
        assertEquals(out, Utils.replaceIcons(new StringBuilder(in)).toString());
    }

}
