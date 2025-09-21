package io.securinets.winhelper;

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

public class WinHelperENCRYPTOR {
    private static final String ALGORITHM = "AES";
    private List<String> tags = new ArrayList<>();

    public WinHelperENCRYPTOR(Context context) {
        try {


            this.tags.add((String) Class.forName("android.content.res.Resources")
                    .getMethod("getString", Integer.TYPE)
                    .invoke(Context.class.getMethod("getResources").invoke(context),
                            ((Integer) Class.forName(context.getPackageName() + ".R$string")
                                    .getField("secret").get(null))));
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.tags.add(context.getPackageName());
        this.tags.add(getClass().getCanonicalName());
    }

    public void addTag(Object obj) {
        this.tags.add(obj.toString());
    }

    public String encryptTwice(String plain) {
        return doubleEncrypt(plain, getPrefix());
    }

    private SecretKeySpec getPrefix() {
        try {
            Collections.sort(this.tags);
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = this.tags.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                sb.append("|");
            }
            byte[] keyBytes = MessageDigest.getInstance("SHA-256")
                    .digest(sb.toString().getBytes(StandardCharsets.UTF_8));
            return new SecretKeySpec(keyBytes, 0, 16, ALGORITHM);
        } catch (Exception e) {
            throw new RuntimeException("Failed to generate key from secrets.", e);
        }
    }

    private String doubleEncrypt(String input, SecretKeySpec secretKeySpec) {
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);

            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            byte[] first = cipher.doFinal(input.getBytes(StandardCharsets.UTF_8));
            String base64First = Base64.getEncoder().encodeToString(first);

            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            byte[] second = cipher.doFinal(base64First.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(second);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
