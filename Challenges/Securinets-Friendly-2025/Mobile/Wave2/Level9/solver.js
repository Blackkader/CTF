Java.perform(function () {
    var Dynamic1 = Java.use("io.securinets.level9.MainActivity");

    Dynamic1.WIN.overload('java.lang.String').implementation = function (key) {

        var newKey = "CHANGED!";
  
       return this.WIN(newKey);
    };
});
