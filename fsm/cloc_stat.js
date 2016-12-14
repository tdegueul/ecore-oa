var fs = require('fs');
var path = require('path');
var basepath = './cloc';
var clocFiles = fs.readdirSync(basepath);
console.log("|project|lines of code|");
console.log("|-------|-------------|");
clocFiles.forEach(function (filename) {
  var json = JSON.parse(fs.readFileSync(path.join(basepath, filename)));
  console.log("|"+filename + "|" + json.Java.code+"|");
});
