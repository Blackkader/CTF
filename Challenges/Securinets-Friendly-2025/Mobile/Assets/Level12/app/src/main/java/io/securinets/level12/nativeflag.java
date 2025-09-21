package io.securinets.level12;

public class nativeflag {
    static { System.loadLibrary("staticflag"); }
    public native String getFlag();
}
