Java.perform(function () {
    var Main = Java.use("io.securinets.level10.MainActivity");

    var callCount = 0;
    var forcedValues = [6,7,8,9,10];

    var original = Main.generate.overload().implementation;

    Main.generate.overload().implementation = function() {
        if (callCount < forcedValues.length) {
            var ret = forcedValues[callCount];
            console.log("generate() -> forced", ret);
            callCount++;
            return ret;
        }

        return original.apply(this, arguments);
    };
});
