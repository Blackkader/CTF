package io.securinets.level8;

import android.content.Context;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class WinHelper{
    private static final String z0 = "AES";
    private List<String> a0 = new ArrayList<>();

    public WinHelper(Context b0) {
        new Thread(() -> {
            while (true) {
                if (c0()) {
                    android.os.Process.killProcess(android.os.Process.myPid());
                    System.exit(1);
                }
                try { Thread.sleep(2000); } catch (InterruptedException ignored) {}
            }
        }).start();

        try {
            this.a0.add((String) Class.forName("android.content.res.Resources")
                    .getMethod("getString", Integer.TYPE)
                    .invoke(Context.class.getMethod("getResources").invoke(b0),
                            ((Integer) Class.forName(b0.getPackageName() + ".R$string")
                                    .getField("secret").get(null))));
        } catch (Exception e) { e.printStackTrace(); }
        this.a0.add(b0.getPackageName());
        this.a0.add(getClass().getCanonicalName());
    }

    private boolean c0() {
        try {
            String[] d0 = {
                    "fr" + "ida",
                    "gum" + "-js-loop",
                    "gad" + "get",
                    "lib" + "frida",
                    "frida" + "-agent"
            };
            try (java.io.BufferedReader e0 = new java.io.BufferedReader(
                    new java.io.FileReader("/proc/" + android.os.Process.myPid() + "/maps"))) {
                String f0;
                while ((f0 = e0.readLine()) != null) {
                    for (String g0 : d0) {
                        if (f0.toLowerCase().contains(g0)) return true;
                    }
                }
            }
            String h0 = i0("/proc/net/tcp");
            if (h0.contains("6A6A") || h0.contains("6A6B")) return true;
            String[] j0 = {
                    "re." + "frida." + "server.Server",
                    "com." + "frida." + "Injector",
                    "re." + "frida." + "gadget"
            };
            for (String k0 : j0) {
                try { Class.forName(k0); return true; }
                catch (ClassNotFoundException ignored) {}
            }
        } catch (Exception ignored) {}
        return false;
    }

    private String i0(String l0) {
        try {
            java.io.BufferedReader m0 = new java.io.BufferedReader(new java.io.FileReader(l0));
            StringBuilder n0 = new StringBuilder();
            String o0;
            while ((o0 = m0.readLine()) != null) n0.append(o0);
            m0.close();
            return n0.toString();
        } catch (Exception ignored) {}
        return "";
    }

    public void p0(Object q0) { this.a0.add(q0.toString()); }

    public String magic(String r0) { return s0(r0, t0()); }

    private SecretKeySpec t0() {
        try {
            Collections.sort(this.a0);
            StringBuilder u0 = new StringBuilder();
            Iterator<String> v0 = this.a0.iterator();
            while (v0.hasNext()) { u0.append(v0.next()); u0.append("|"); }
            byte[] w0 = MessageDigest.getInstance("SHA-256")
                    .digest(u0.toString().getBytes(StandardCharsets.UTF_8));
            return new SecretKeySpec(w0, 0, 16, z0);
        } catch (Exception e) {
            throw new RuntimeException("xx", e);
        }
    }

    private String s0(String x0, SecretKeySpec y0) {
        try {
            Cipher z1 = Cipher.getInstance(z0);
            byte[] a1 = Base64.getDecoder().decode(x0);
            z1.init(Cipher.DECRYPT_MODE, y0);
            byte[] b1 = z1.doFinal(a1);
            String c1 = new String(b1, StandardCharsets.UTF_8);
            byte[] d1 = Base64.getDecoder().decode(c1);
            z1.init(Cipher.DECRYPT_MODE, y0);
            byte[] e1 = z1.doFinal(d1);
            return new String(e1, StandardCharsets.UTF_8);
        } catch (Exception e) { e.printStackTrace(); return null; }
    }
}
