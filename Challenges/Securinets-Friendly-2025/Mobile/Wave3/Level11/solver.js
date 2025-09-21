Java.perform(function () {
    var Dayum = Java.use("io.securinets.level11.Dayum");

    Dayum.onCreate.overload("android.os.Bundle").implementation = function(savedInstanceState) {
        this.onCreate(savedInstanceState); 

        try {

            var locals = Java.use('java.lang.reflect.Field');

           
            var deobfuscate = Java.use("io.securinets.level11.deobfuscate");
            deobfuscate.f4.implementation = function(encflag) {
                var decflag = this.f4(encflag); 
                console.log("[*] decflag: " + decflag); 
                return decflag; 
            };
        } catch (e) {
            console.error(e);
        }
    };
});
