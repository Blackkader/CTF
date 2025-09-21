package io.securinets.level11;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Dayum extends AppCompatActivity {
    private static final byte[] P1 = new byte[] {
            (byte)0xAE, (byte)0x37, (byte)0x78, (byte)0xC5, (byte)0xC7, (byte)0x12, (byte)0x88, (byte)0x5B, (byte)0x95, (byte)0xA6,
    };
    private static final byte[] P2 = new byte[] {
            (byte)0x59, (byte)0x52, (byte)0x14, (byte)0xC8, (byte)0xFA, (byte)0x10, (byte)0xE4, (byte)0x77, (byte)0xBA, (byte)0x3F,
    };
    private static final byte[] P3 = new byte[] {
            (byte)0x25, (byte)0x95, (byte)0x89, (byte)0x41, (byte)0x64, (byte)0x9B, (byte)0x1F, (byte)0xD0, (byte)0x7C, (byte)0x81, (byte)0x09, (byte)0xE1,
            (byte)0xA1, (byte)0x12, (byte)0xC7, (byte)0xB3, (byte)0xA5, (byte)0xB2,
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        String p1 = deobfuscate.decodePart(P1, 1);
        String p2 = deobfuscate.decodePart(P2, 2);
        String p3 = deobfuscate.decodePart(P3, 3);
        String encflag =  p1 + p2 + p3 ;
        String decflag = deobfuscate.f4(encflag);
    }

}
