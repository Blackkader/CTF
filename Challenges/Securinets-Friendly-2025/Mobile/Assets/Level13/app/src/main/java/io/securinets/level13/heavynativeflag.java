package io.securinets.level13;

public class heavynativeflag {
    static { System.loadLibrary("encflag"); }
    public native byte[] magic(String input);
}
