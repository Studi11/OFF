package com.studi.off;

import android.content.Context;
import android.hardware.ConsumerIrManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "IRtest";

    ConsumerIrManager ir;
    private HashMap<String, IRCode> codes = new HashMap<>();

    private void initCodes() {
        // Toggle
        codes.put("LOEWE_TOGGLE",           new IRCode("0000 006b 0000 000c 0022 0023 0044 0023 0022 0023 0022 0023 0022 0023 0022 0023 0022 0023 0022 0023 0022 0047 0022 0023 0044 0023 0022 0d8f"));
        codes.put("SAMSUNG_TOGGLE",         new IRCode("0000 006d 0022 0003 00a9 00a8 0015 003f 0015 003f 0015 003f 0015 0015 0015 0015 0015 0015 0015 0015 0015 0015 0015 003f 0015 003f 0015 003f 0015 0015 0015 0015 0015 0015 0015 0015 0015 0015 0015 0015 0015 003f 0015 0015 0015 0015 0015 0015 0015 0015 0015 0015 0015 0015 0015 0040 0015 0015 0015 003f 0015 003f 0015 003f 0015 003f 0015 003f 0015 003f 0015 0702 00a9 00a8 0015 0015 0015 0e6e"));
        codes.put("PANASONIC_TOGGLE",       new IRCode("0000 0071 0000 0032 0080 0040 0010 0010 0010 0031 0010 0010 0010 0010 0010 0010 0010 0010 0010 0010 0010 0010 0010 0010 0010 0010 0010 0010 0010 0010 0010 0010 0010 0031 0010 0010 0010 0010 0010 0010 0010 0010 0010 0010 0010 0010 0010 0010 0010 0010 0010 0010 0010 0031 0010 0010 0010 0010 0010 0010 0010 0010 0010 0010 0010 0010 0010 0010 0010 0010 0010 0031 0010 0010 0010 0031 0010 0031 0010 0031 0010 0031 0010 0010 0010 0010 0010 0031 0010 0010 0010 0031 0010 0031 0010 0031 0010 0031 0010 0010 0010 0031 0010 0A9E"));
        codes.put("PHILIPS_TOGGLE",         new IRCode("0000 0073 0000 000c 0020 0020 0020 0020 0040 0020 0020 0020 0020 0020 0020 0020 0020 0020 0020 0020 0020 0040 0020 0020 0040 0020 0020 0cce"));
        codes.put("LG_TOGGLE",              new IRCode("0000 006d 0022 0002 0154 00ab 0015 0015 0015 0015 0015 0041 0015 0016 0015 0016 0015 0015 0015 0015 0015 0015 0015 0040 0015 0040 0015 0015 0015 0041 0015 0041 0015 0040 0015 0040 0015 0040 0015 0015 0015 0015 0015 0015 0015 0041 0015 0016 0015 0016 0015 0015 0015 0016 0015 0041 0015 0041 0015 0040 0015 0015 0015 0040 0015 0041 0015 0041 0015 0040 0015 0612 0154 0056 0015 0e5d"));
        codes.put("SONY_1_TOGGLE_POSSIBLE", new IRCode("0000 0067 0000 000d 0060 0018 0018 0018 0018 0018 0018 0018 0030 0018 0030 0018 0030 0018 0018 0018 0030 0018 0018 0018 0018 0018 0018 0018 0018 0410"));
        codes.put("SONY_RM-Y128_TOGGLE",    new IRCode("0000 0067 0000 000d 0061 0018 0030 0018 0018 0018 0030 0018 0018 0018 0030 0018 0018 0018 0018 0018 0030 0018 0018 0018 0018 0018 0018 0018 0018 0403"));

        // On
        codes.put("PHILIPS_ON",             new IRCode("0000 5000 0000 0000 0001 0000 003F"));
        codes.put("PANASONIC_0_ON",         new IRCode("0000 0048 0048 0000 00c1 00c2 0031 0030 0031 0030 0031 0030 0031 0030 0031 0030 0031 0030 0031 0030 0031 0030 0031 0030 0031 0030 0031 0091 0031 0091 0031 0091 0031 0091 0031 0091 0031 0091 0031 0091 0031 0091 0031 0091 0031 0091 0031 0091 0031 0030 0031 0886 00c1 00c1 0031 0030 0031 0030 0031 0030 0031 0030 0031 0030 0031 0030 0031 0030 0031 0030 0031 0030 0031 0030 0031 0091 0031 0091 0031 0091 0031 0091 0031 0091 0031 0091 0031 0091 0031 0091 0031 0091 0031 0091 0031 0091 0031 0030 0031 0886 00c1 00c1 0031 0030 0031 0030 0031 0030 0031 0030 0031 0010 0031 0030 0031 0030 0031 0030 0031 0030 0031 0030 0031 0091 0031 0091 0031 0010 0031 0030 0031 0091 0031 0091 0031 0091 0031 0091 0031 0091 0031 0091 0031 0091 0031 0030 0031 00c2"));
        codes.put("PANASONIC_1_ON",         new IRCode("0000 0071 0000 0032 0080 003F 0010 0010 0010 0030 0010 0010 0010 0010 0010 0010 0010 0010 0010 0010 0010 0010 0010 0010 0010 0010 0010 0010 0010 0010 0010 0010 0010 0030 0010 0010 0010 0010 0010 0010 0010 0010 0010 0010 0010 0010 0010 0010 0010 0010 0010 0010 0010 0030 0010 0010 0010 0010 0010 0010 0010 0010 0010 0010 0010 0010 0010 0010 0010 0010 0010 0010 0010 0030 0010 0030 0010 0030 0010 0030 0010 0030 0010 0010 0010 0010 0010 0010 0010 0030 0010 0030 0010 0030 0010 0030 0010 0030 0010 0010 0010 0030 0010 0A98"));
        codes.put("LOEWE_0_ON",             new IRCode("0000 0073 0000 000B 0020 0020 0040 0020 0020 0020 0020 0020 0020 0020 0020 0020 0020 0020 0020 0040 0040 0040 0020 0020 0040 0CC4"));
        codes.put("LOEWE_1_ON",             new IRCode("0000 5000 0000 0000 0001 0000 0016"));
        codes.put("SAMSUNG_0_ON",           new IRCode("0000 006D 0000 0022 00AC 00AC 0015 0040 0015 0040 0015 0040 0015 0015 0015 0015 0015 0015 0015 0015 0015 0015 0015 0040 0015 0040 0015 0040 0015 0015 0015 0015 0015 0015 0015 0015 0015 0015 0015 0040 0015 0015 0015 0015 0015 0040 0015 0040 0015 0015 0015 0015 0015 0040 0015 0015 0015 0040 0015 0040 0015 0015 0015 0015 0015 0040 0015 0040 0015 0015 0015 0689"));
        codes.put("SAMSUNG_1_ON",           new IRCode("0000 006D 0000 0022 00AC 00AC 0015 0040 0015 0040 0015 0040 0015 0015 0015 0015 0015 0015 0015 0015 0015 0015 0015 0040 0015 0040 0015 0040 0015 0015 0015 0015 0015 0015 0015 0015 0015 0015 0015 0040 0015 0015 0015 0015 0015 0040 0015 0040 0015 0015 0015 0015 0015 0040 0015 0015 0015 0040 0015 0040 0015 0015 0015 0015 0015 0040 0015 0040 0015 0015 0015 0680"));
        codes.put("SONY_0_ON",              new IRCode("0000 0067 0000 000d 0060 0018 0018 0018 0018 0018 0018 0018 0030 0018 0030 0018 0030 0018 0018 0018 0030 0018 0018 0018 0018 0018 0018 0018 0018 0410"));
        codes.put("SONY_1_ON",              new IRCode("0000 0067 0000 000d 0060 0018 0018 0018 0030 0018 0030 0018 0030 0018 0018 0018 0030 0018 0018 0018 0030 0018 0018 0018 0018 0018 0018 0018 0018 03f6"));
        codes.put("SONY_2_ON",              new IRCode("0000 0067 0000 000d 0060 0018 0018 0018 0030 0018 0030 0018 0030 0018 0018 0018 0030 0018 0018 0018 0030 0018 0018 0018 0018 0018 0018 0018 0018 03f5"));
        codes.put("SONY_WEBTV_ON",          new IRCode("0000 0067 0000 0015 0060 0018 0018 0018 0030 0018 0030 0018 0030 0018 0018 0018 0030 0018 0018 0018 0018 0018 0030 0018 0018 0018 0030 0018 0030 0018 0030 0018 0018 0018 0018 0018 0030 0018 0030 0018 0030 0018 0030 0018 0018 01e5"));
        codes.put("PIONEER_PLASMA_ON",      new IRCode("0000 0067 0000 0022 0155 00ac 0015 0016 0015 0041 0015 0016 0015 0041 0015 0016 0015 0041 0015 0016 0015 0041 0015 0041 0015 0016 0015 0041 0015 0016 0015 0041 0015 0016 0015 0041 0015 0016 0015 0016 0015 0041 0015 0016 0015 0041 0015 0041 0015 0016 0015 0016 0015 0016 0015 0041 0015 0016 0015 0041 0015 0016 0015 0016 0015 0041 0015 0041 0015 0041 0015 058f"));
        codes.put("PIONEER_RP_1_ON",        new IRCode("0000 007f 0000 0022 0112 008b 0011 0010 0011 0034 000f 0010 0010 0034 0012 0010 0012 0034 0012 0011 0010 0034 000f 0034 0012 0010 0011 0034 0011 0011 0011 0034 0011 0010 0011 0034 0011 0010 0011 0010 0011 0033 0011 0010 0011 0034 0011 0034 0011 0010 0011 0010 0010 0010 000f 0034 0010 0010 0012 0034 0012 0010 0012 0010 0012 0034 000f 0035 0011 0034 0012 0479"));
        codes.put("SHARP_LCD_ON",           new IRCode("0000 006d 0000 0020 000a 0047 000a 001e 000a 001e 000a 001e 000a 0047 000a 001e 000a 0047 000a 001e 000a 0047 000a 001e 000a 001e 000a 0047 000a 001e 000a 0047 000a 001e 000a 068b 000a 0047 000a 001e 000a 001e 000a 001e 000a 0047 000a 0047 000a 001e 000a 0047 000a 001e 000a 0047 000a 0047 000a 001e 000a 0047 000a 001e 000a 0047 000a 068b"));
        codes.put("SHARP_RP_ON",            new IRCode("0000 006d 0000 0032 0080 0040 0010 0010 0010 002f 0010 0010 0010 002f 0010 0010 0010 002f 0010 0010 0010 002f 0010 0010 0010 002f 0010 0010 0010 002f 0010 002f 0010 0010 0010 002f 0010 0010 0010 002f 0010 002f 0010 002f 0010 002f 0010 0010 0010 0010 0010 0010 0010 002f 0010 0010 0010 002f 0010 0010 0010 0010 0010 002f 0010 0010 0010 0010 0010 0010 0010 0010 0010 002f 0010 0010 0010 002f 0010 0010 0010 0010 0010 002f 0010 0010 0010 0010 0010 002f 0010 0010 0010 0010 0010 002f 0010 002f 0010 002f 0010 0010 0011 0a88"));
        codes.put("SHARP_1_ON",             new IRCode("0000 0069 0010 0020 000a 0044 000a 001d 000a 001d 000a 001d 000a 0044 000a 001d 000a 0044 000a 001d 000a 0044 000a 001d 000a 001d 000a 0044 000a 001d 000a 0044 000a 001d 000a 0735 000a 0044 000a 001d 000a 001d 000a 001d 000a 0044 0044 001d 000a 001d 000a 0044 000a 001d 000a 0044 000a 0044 000a 001d 000a 0044 000a 001d 000a 0044 000a 0652 000a 0044 000a 001d 000a 001d 000a 001d 000a 0044 000a 0044 000a 0044 000a 001d 000a 0044 000a 001d 000a 001d 000a 0044 000a 001d 000a 0044 000a 001d 000a 0735"));

        // Off
        codes.put("PHILIPS_OFF",            new IRCode("0000 5000 0000 0000 0001 0000 000C"));
        codes.put("PANASONIC_OFF",          new IRCode("0000 0048 0048 0000 00c1 00c2 0031 0030 0031 0030 0031 0030 0031 0030 0031 0030 0031 0030 0031 0030 0031 0030 0031 0030 0031 0030 0031 0091 0031 0091 0031 0091 0031 0091 0031 0091 0031 0091 0031 0091 0031 0091 0031 0091 0031 0091 0031 0091 0031 0030 0031 0886 00c1 00c1 0031 0030 0031 0030 0031 0030 0031 0030 0031 0030 0031 0030 0031 0030 0031 0030 0031 0030 0031 0030 0031 0091 0031 0091 0031 0091 0031 0091 0031 0091 0031 0091 0031 0091 0031 0091 0031 0091 0031 0091 0031 0091 0031 0030 0031 0886 00c1 00c1 0031 0030 0031 0030 0031 0030 0031 0030 0031 0030 0031 0030 0031 0030 0031 0030 0031 0030 0031 0030 0031 0091 0031 0091 0031 0030 0031 0030 0031 0091 0031 0091 0031 0091 0031 0091 0031 0091 0031 0091 0031 0091 0031 0030 0031 00c2"));
        codes.put("PANASONIC1_OFF",         new IRCode("0000 0071 0000 0032 0080 003F 0010 0010 0010 0030 0010 0010 0010 0010 0010 0010 0010 0010 0010 0010 0010 0010 0010 0010 0010 0010 0010 0010 0010 0010 0010 0010 0010 0030 0010 0010 0010 0010 0010 0010 0010 0010 0010 0010 0010 0010 0010 0010 0010 0010 0010 0010 0010 0030 0010 0010 0010 0010 0010 0010 0010 0010 0010 0010 0010 0010 0010 0010 0010 0010 0010 0030 0010 0030 0010 0030 0010 0030 0010 0030 0010 0030 0010 0010 0010 0010 0010 0030 0010 0030 0010 0030 0010 0030 0010 0030 0010 0030 0010 0010 0010 0030 0010 0A98"));
        codes.put("LOEWE_0_OFF",            new IRCode("0000 0073 0000 000C 0020 0020 0040 0020 0020 0020 0020 0020 0020 0020 0020 0020 0020 0020 0020 0040 0020 0020 0040 0020 0020 0040 0020 0CA4"));
        codes.put("LOEWE_1_OFF",            new IRCode("0000 5000 0000 0000 0001 0000 0019"));
        codes.put("LOEWE_2_OFF",            new IRCode("0000 0072 000c 0000 0020 0020 0040 0020 0020 0020 0020 0020 0020 0020 0020 0020 0020 0020 0020 0040 0020 0020 0040 0020 0020 0040 0020 0020"));
        codes.put("SAMSUNG_0_OFF",          new IRCode("0000 006D 0000 0022 00AC 00AC 0015 0040 0015 0040 0015 0040 0015 0015 0015 0015 0015 0015 0015 0015 0015 0015 0015 0040 0015 0040 0015 0040 0015 0015 0015 0015 0015 0015 0015 0015 0015 0015 0015 0015 0015 0015 0015 0015 0015 0040 0015 0040 0015 0015 0015 0015 0015 0040 0015 0040 0015 0040 0015 0040 0015 0015 0015 0015 0015 0040 0015 0040 0015 0015 0015 0689"));
        codes.put("SAMSUNG_1_OFF",          new IRCode("0000 006D 0000 0022 00AC 00AC 0015 0040 0015 0040 0015 0040 0015 0015 0015 0015 0015 0015 0015 0015 0015 0015 0015 0040 0015 0040 0015 0040 0015 0015 0015 0015 0015 0015 0015 0015 0015 0015 0015 0015 0015 0015 0015 0015 0015 0040 0015 0040 0015 0015 0015 0015 0015 0040 0015 0040 0015 0040 0015 0040 0015 0015 0015 0015 0015 0040 0015 0040 0015 0015 0015 0680"));
        codes.put("SAMSUNG_2_OFF",          new IRCode("0000 006C 0022 0000 00AD 00AD 0015 0041 0015 0041 0015 0041 0015 0015 0015 0015 0015 0015 0015 0015 0015 0015 0015 0041 0015 0041 0015 0041 0015 0015 0015 0015 0015 0015 0015 0015 0015 0015 0015 0015 0015 0015 0015 0015 0015 0041 0015 0041 0015 0015 0015 0015 0015 0041 0015 0041 0015 0041 0015 0041 0015 0015 0015 0015 0015 0041 0015 0041 0015 0015 0015 0728"));
        codes.put("SONY_RM-Y128_OFF",       new IRCode("0000 0067 0000 0010 0061 0018 0018 0018 0030 0018 0030 0018 0030 0018 0018 0018 0030 0018 0030 0018 0018 0018 0018 0018 0030 0018 0018 0018 0018 0018 0030 0018 0018 0018 0030 0314"));
        codes.put("SONY_1_OFF",             new IRCode("0000 0067 0000 000d 0060 0018 0018 0018 0018 0018 0018 0018 0030 0018 0030 0018 0030 0018 0018 0018 0030 0018 0018 0018 0018 0018 0018 0018 0018 0410"));
        codes.put("SONY_2_OFF",             new IRCode("0000 0067 0000 000d 0060 0018 0030 0018 0030 0018 0030 0018 0030 0018 0018 0018 0030 0018 0018 0018 0030 0018 0018 0018 0018 0018 0018 0018 0018 03de"));
        codes.put("SONY_WEBTV_OFF",         new IRCode("0000 0067 0000 0015 0060 0018 0030 0018 0030 0018 0030 0018 0030 0018 0018 0018 0030 0018 0018 0018 0018 0018 0030 0018 0018 0018 0030 0018 0030 0018 0030 0018 0018 0018 0018 0018 0030 0018 0030 0018 0030 0018 0030 0018 0018 01e5"));
        codes.put("PIONEER_PLASMA_OFF",     new IRCode("0000 0067 0000 0022 0155 00ac 0015 0016 0015 0041 0015 0016 0015 0041 0015 0016 0015 0041 0015 0016 0015 0041 0015 0041 0015 0016 0015 0041 0015 0016 0015 0041 0015 0016 0015 0041 0015 0016 0015 0041 0015 0041 0015 0016 0015 0041 0015 0041 0015 0016 0015 0016 0015 0016 0015 0016 0015 0016 0015 0041 0015 0016 0015 0016 0015 0041 0015 0041 0015 0041 0015 058f"));
        codes.put("PIONEER_RP_1_OFF",       new IRCode("0000 0085 0000 0022 0106 0084 000f 0010 000f 0032 0010 000f 0011 0031 0013 000f 0011 0031 0010 0010 0010 0031 0010 0032 0011 000f 000e 0031 0010 000f 0010 0031 0011 0010 0012 0031 0011 000f 0011 0032 0010 0031 000f 0010 0011 0031 0010 0031 0011 000f 000f 000f 000f 000f 0010 0010 0012 000f 0012 0031 0011 0010 0010 000f 0010 0031 0010 0031 0010 0031 000f 0446"));
        codes.put("SHARP_LCD_OFF",          new IRCode("0000 006d 0000 0020 000a 0047 000a 001e 000a 001e 000a 001e 000a 0047 000a 0047 000a 0047 000a 001e 000a 0047 000a 001e 000a 001e 000a 0047 000a 001e 000a 0047 000a 001e 000a 068b 000a 0047 000a 001e 000a 001e 000a 001e 000a 0047 000a 001e 000a 001e 000a 0047 000a 001e 000a 0047 000a 0047 000a 001e 000a 0047 000a 001e 000a 0047 000a 068b"));
        codes.put("SHARP_RP_OFF",           new IRCode("0000 006d 0000 0032 0080 0040 0010 0010 0010 002f 0010 0010 0010 002f 0010 0010 0010 002f 0010 0010 0010 002f 0010 0010 0010 002f 0010 0010 0010 002f 0010 002f 0010 0010 0010 002f 0010 0010 0010 002f 0010 002f 0010 002f 0010 002f 0010 0010 0010 0010 0010 0010 0010 002f 0010 0010 0010 002f 0010 0010 0010 0010 0010 002f 0010 0010 0010 0010 0010 0010 0010 002f 0010 002f 0010 0010 0010 002f 0010 0010 0010 0010 0010 002f 0010 0010 0010 0010 0010 002f 0010 0010 0010 0010 0010 0010 0010 002f 0010 002f 0010 0010 0011 0a88"));
        codes.put("SHARP_1_OFF",            new IRCode("0000 006d 0010 0020 000a 0044 000b 001d 000a 001d 000a 001d 000b 0044 000a 0044 000b 0044 000a 001d 000a 0044 000b 001d 000a 001d 000a 0044 000b 001d 000a 0044 000b 001d 000b 0735 000a 0045 000a 001d 000a 001d 000b 001d 000a 0044 000a 001d 000b 001d 000a 0045 000a 001d 000b 0044 000a 0045 000a 001d 000b 0044 000a 001d 000b 0044 000a 0652 000b 0044 000a 001d 000b 001d 000a 001d 000a 0044 000b 0044 000a 0044 000b 001d 000a 0044 000a 001d 000b 001d 000a 0044 000a 001d 000b 0044 000a 001d 000b 0735"));

        for (Map.Entry<String, IRCode> code : codes.entrySet()) {
            for (Map.Entry<String, IRCode> c : codes.entrySet()) {
                if (code.getValue().getHexString().equals(c.getValue().getHexString()) && !code.getKey().equals(c.getKey())) {
                    Log.d(TAG, "Dublicate: "+ code.getKey() + " | " + c.getKey());
                }
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "=========");
        setContentView(R.layout.activity_main);

        final Button toggleButton = (Button) findViewById(R.id.toggleButton);
        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggle();
            }
        });
        final Button onButton = (Button) findViewById(R.id.onButton);
        onButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                on();
            }
        });
        final Button offButton = (Button) findViewById(R.id.offButton);
        offButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                off();
            }
        });

        ir = (ConsumerIrManager) getSystemService(Context.CONSUMER_IR_SERVICE);

        Log.d("IRtest", "ir: " + ir.hasIrEmitter());

        if (!ir.hasIrEmitter()) {
            toggleButton.setEnabled(false);
            onButton.setEnabled(false);
            offButton.setEnabled(false);
        }

        ConsumerIrManager.CarrierFrequencyRange[] r = ir.getCarrierFrequencies();
        for (ConsumerIrManager.CarrierFrequencyRange f : r) {
            Log.d("IRtest", "min: "+ f.getMinFrequency());
            Log.d("IRtest", "max: "+ f.getMaxFrequency());
        }

        initCodes();
        //Log.d(TAG, codes.get("LG_TOGGLE").getFreq() + " " + Arrays.toString(codes.get("LG_TOGGLE").getPattern()));
        Log.d(TAG, "" + hex2dec(codes.get("LG_TOGGLE").getHexString()));
    }

    private void toggle() {
        Log.d(TAG, "toggle start");
        String codeName;
        IRCode irCode;
        for (Map.Entry<String, IRCode> code : codes.entrySet()) {
            codeName = code.getKey();
            irCode = code.getValue();
            if (codeName.contains("_TOGGLE")) {
                irCode.emit();
            }
        }
        Log.d(TAG, "toggle end");
    }

    private void on() {
        Log.d(TAG, "on start");
        String codeName;
        IRCode irCode;
        for (Map.Entry<String, IRCode> code : codes.entrySet()) {
            codeName = code.getKey();
            irCode = code.getValue();
            if (codeName.contains("_ON")) {
                irCode.emit();
            }
        }
        Log.d(TAG, "on end");
    }

    private void off() {
        Log.d(TAG, "off start");
        String codeName;
        IRCode irCode;
        for (Map.Entry<String, IRCode> code : codes.entrySet()) {
            codeName = code.getKey();
            irCode = code.getValue();
            if (codeName.contains("_OFF")) {
                irCode.emit();
            }
        }
        Log.d(TAG, "off end");
    }

    protected String hex2dec(String irData) {
        List<String> list = new ArrayList<String>(Arrays.asList(irData.split(" ")));
        list.remove(0); // dummy
        int frequency = Integer.parseInt(list.remove(0), 16); // frequency
        list.remove(0); // seq1
        list.remove(0); // seq2

        for (int i = 0; i < list.size(); i++) {
            list.set(i, Integer.toString(Integer.parseInt(list.get(i), 16)));
        }

        frequency = (int) (1000000 / (frequency * 0.241246));
        list.add(0, Integer.toString(frequency));

        irData = "";
        for (String s : list) {
            irData += s + ",";
        }
        return irData;
    }

    protected String dec2hex(String decString) {
        String hexString = "0000 ";
        List<String> list = new ArrayList<String>(Arrays.asList(decString.split(",")));
        int freq = Integer.parseInt(list.get(0));
        int freq2 = (int) (freq / 1000000 * 0.241246);
        String freq3 = Integer.toHexString(freq2);
        while (freq3.length() < 4) {
            freq3 = "0"+freq3;
        }
        hexString += freq3 + " ";
        hexString += "0000 0000";
        for (int i=0; i<list.size(); i++) {
            String c = list.get(i);
            c = Integer.toHexString(Integer.parseInt(c));
            while (c.length() < 4) {
                c = "0" + c;
            }
            hexString += c + " ";
        }
        return hexString;
    }

    private class IRCode {

        private String hexString;
        private int freq;
        private int[] pattern;

        public IRCode(String hexString) {
            this.hexString = hexString;
            calculatePatFreq();
        }

        public IRCode(int[] freqPattern) {
            this.freq = freqPattern[0];
            this.pattern = new int[freqPattern.length-1];
            System.arraycopy(freqPattern,1,this.pattern,0,freqPattern.length-1);
            calculateHexString();
        }

        private void calculatePatFreq() {
                String dexCode = hex2dec(this.hexString);

                List<String> list = new ArrayList<String>(Arrays.asList(dexCode.split(",")));
                int[] pattern = new int[list.size() - 1];
                int frequency = Integer.parseInt(list.get(0));
                int pulses = 1000000 / frequency;
                int count;
                int duration;

                list.remove(0);

                for (int i = 0; i < list.size(); i++) {
                    count = Integer.parseInt(list.get(i));
                    duration = count * pulses;
                    pattern[i] = duration;
                }
                this.pattern = pattern;
                this.freq = frequency;
        }

        private void calculateHexString() {
            String dexString = "";
            dexString += this.freq + ",";
            int pulses = 1000000 / this.freq;
            int count;
            for (int i=0; i<pattern.length; i++) {
                count = this.pattern[i] / pulses;
                dexString += count + ",";
            }
            String hexString = dec2hex(dexString);
            this.hexString = hexString;
        }

        public void emit() {
            try {
                ir.transmit(this.freq, this.pattern);
            } catch (IllegalArgumentException e) {
                Log.e(TAG, "transmit error : " + this.hexString);
                e.printStackTrace();
            }
        }

        public String getHexString() {
            return hexString;
        }

        public int getFreq() {
            return freq;
        }

        public int[] getPattern() {
            return pattern;
        }
    }

    @Override
    protected void onDestroy() {
        codes = null;
        super.onDestroy();
    }

}
