package io.securinets.level10;

import android.content.Context;
import android.util.Log;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class WinHelper {
    private static final String q0 = new String(new char[]{'A','E','S'});
    private List<String> r0 = new ArrayList<>();

    public WinHelper(Context s0) {
        try {
            Object t0 = Context.class.getMethod("getResources").invoke(s0);
            String u0 = s0.getPackageName() + ".R$string";
            Integer v0 = (Integer) Class.forName(u0).getField("secret").get(null);
            String w0 = (String) Class.forName("android.content.res.Resources")
                    .getMethod("getString", Integer.TYPE)
                    .invoke(t0, v0);
            this.r0.add(w0);
        } catch (Exception x0) {
            x0.printStackTrace();
        }
        this.r0.add(s0.getPackageName());
        this.r0.add(getClass().getCanonicalName());
    }

    public void y0(Object z0) { this.r0.add(z0.toString()); }

    public String magic(String a1) { return b1(a1, c1()); }

    private SecretKeySpec c1() {
        try {
            Collections.sort(this.r0);
            StringBuilder d1 = new StringBuilder();
            for (Iterator<String> e1 = this.r0.iterator(); e1.hasNext();) {
                d1.append(e1.next()).append("|");
            }
            String f1 = new String(new char[]{'S','H','A','-','2','5','6'});
            byte[] g1 = MessageDigest.getInstance(f1)
                    .digest(d1.toString().getBytes(StandardCharsets.UTF_8));
            return new SecretKeySpec(g1, 0, 16, q0);
        } catch (Exception h1) {
            throw new RuntimeException("xx", h1);
        }
    }

    private String b1(String i1, SecretKeySpec j1) {
        try {
            Cipher k1 = Cipher.getInstance(q0);
            byte[] l1 = Base64.getDecoder().decode(i1);
            k1.init(Cipher.DECRYPT_MODE, j1);
            byte[] m1 = k1.doFinal(l1);
            String n1 = new String(m1, StandardCharsets.UTF_8);
            byte[] o1 = Base64.getDecoder().decode(n1);
            k1.init(Cipher.DECRYPT_MODE, j1);
            byte[] p1 = k1.doFinal(o1);
            return new String(p1, StandardCharsets.UTF_8);
        } catch (Exception q1) {
            q1.printStackTrace();
            return null;
        }
    }
}
