const lighthouse = require('lighthouse');
const chromeLauncher = require('chrome-launcher');
const url = require('url');
const dateFormat = require('dateformat');
const fs = require('file-system');
const readline = require('readline');

const opts = {onlyCategories: ['performance']};
const file = process.argv[2];
const now = new Date();

let delay = 0;

function auditUrl(url, opts) {
  return chromeLauncher.launch(opts).then(chrome => {
    opts.port = chrome.port;
    return lighthouse(url, opts).then(results =>
      chrome.kill().then(() => results));
  });
}

const rl = readline.createInterface({
  input: fs.createReadStream(file),
  crlfDelay: Infinity
});

rl.on('line', function (line) {
  delay += 10000;    
  setTimeout(function() {
    console.log(`Line from file: ${line}`);
    auditUrl(line, opts).then(results => {
      let folder = dateFormat(now, 'yyyymmdd');
      let filename = url.parse(line).hostname + url.parse(line).pathname;
      filename = folder + filename.replace(/[^a-z0-9]/gi, '_').toLowerCase();
      fs.writeFile(`./report/${folder}/_${filename}.html`, results.report);
    });
  }, 10000 + delay);    
});
