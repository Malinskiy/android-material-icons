package com.malinskiy.materialicons;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static com.malinskiy.materialicons.Iconify.IconValue.*;
import static org.junit.Assert.assertEquals;

@Config(manifest = Config.NONE)
@RunWith(RobolectricTestRunner.class)
public class UtilsTest {

    @Test
    public void test_replaceIcons() {
        test("A{md_add}A", "A" + md_add.character + "A");
    }

    @Test
    public void test_replaceIcons_noIcons() {
        test("A A", "A A");
    }

    @Test
    public void test_replaceIcons_manyIcons() {
        test("A{md_add}A{md_adb}A", "A" + md_add.character + "A" + md_adb.character + "A");
    }

    @Test
    public void test_replaceIcons_withDash() {
        test("A{md-add}A{md-adb}A", "A" + md_add.character + "A" + md_adb.character + "A");
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
