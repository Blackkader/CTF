package io.securinets.level11;

import java.security.MessageDigest;
import java.util.Arrays;
import java.nio.charset.StandardCharsets;

public final class deobfuscate {
    private deobfuscate() {}


    public static String decodePart(byte[] x, int y) {
        try {
            byte[] a = f1(x.length, y);
            byte[] b = new byte[x.length];
            for (int i = 0; i < x.length; i++) b[i] = (byte)((x[i] & 0xFF) ^ (a[i] & 0xFF));
            byte[] c = f2(b);
            int[] d = f3(c.length, y);
            byte[] e = invPerm(c, d);
            return new String(e, StandardCharsets.UTF_8);
        } catch (Exception ex) {
            return "";
        }
    }


    private static final String A = "superidol";
    private static final String B = "silksongisreal";


    private static byte[] f2(byte[] x) {
        byte[] a = Arrays.copyOf(x, x.length);
        for (int i = a.length - 1; i >= 1; i--) a[i] = (byte)(((a[i] & 0xFF) - (a[i-1] & 0xFF)) & 0xFF);
        return a;
    }

    private static byte[] f1(int l, int idx) throws Exception {
        byte[] o = new byte[l];
        int p = 0, ctr = 0;
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        while (p < l) {
            md.reset();
            md.update(A.getBytes(StandardCharsets.UTF_8));
            md.update((byte)0xFF);
            md.update(B.getBytes(StandardCharsets.UTF_8));
            md.update((byte)(idx & 0xFF));
            md.update(new byte[] { (byte)((ctr >> 24) & 0xFF), (byte)((ctr >> 16) & 0xFF),
                    (byte)((ctr >> 8) & 0xFF), (byte)(ctr & 0xFF) });
            byte[] h = md.digest();
            int c = Math.min(h.length, l - p);
            System.arraycopy(h, 0, o, p, c);
            p += c;
            ctr++;
        }
        return o;
    }

    private static int[] f3(int n, int idx) throws Exception {
        if (n <= 1) { int[] r = new int[n]; for(int i=0;i<n;i++) r[i]=i; return r; }
        int[] a = new int[n]; for(int i=0;i<n;i++) a[i]=i;
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        int ctr = 0;
        for (int i = n - 1; i > 0; i--) {
            md.reset();
            md.update(A.getBytes(StandardCharsets.UTF_8));
            md.update((byte)0xFF);
            md.update(B.getBytes(StandardCharsets.UTF_8));
            md.update((byte)(idx & 0xFF));
            md.update(new byte[] { (byte)((ctr >> 24) & 0xFF), (byte)((ctr >> 16) & 0xFF),
                    (byte)((ctr >> 8) & 0xFF), (byte)(ctr & 0xFF) });
            byte[] h = md.digest();
            long r = ((long)(h[0]&0xFF) << 24) | ((long)(h[1]&0xFF) << 16) | ((long)(h[2]&0xFF) << 8) | ((long)(h[3]&0xFF));
            int j = (int)(r % (i + 1));
            int tmp = a[i]; a[i] = a[j]; a[j] = tmp;
            ctr++;
        }
        return a;
    }
    public static String f4(String s) {
        try {
            char[] x = s.toCharArray();
            char[] y = new char[x.length];
            int[] map = new int[]{8,1,2,3,4,5,6,7,0,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,9,40,41,42};
            for(int i=0;i<x.length;i++){ y[i] = i<map.length ? x[map[i]] : x[i]; }
            StringBuilder sb = new StringBuilder();
            int junk=0;
            for(int i=0;i<y.length;i++){
                sb.append(y[i]);
                junk+=i*3%7;
            }
            char[] finalArr = sb.toString().toCharArray();
            for(int i=0;i<finalArr.length;i++){ finalArr[i]^=0; }
            int dummy=123;
            for(int i=0;i<5;i++){ dummy=dummy^i; dummy=dummy<<1; dummy=dummy=dummy>>1; }
            return new String(finalArr);
        } catch(Exception ex){
            return s;
        }
    }


    private static byte[] invPerm(byte[] x, int[] perm) {
        byte[] o = new byte[x.length];
        for (int i = 0; i < x.length; i++) o[perm[i]] = x[i];
        return o;
    }
}
