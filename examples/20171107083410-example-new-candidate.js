'use strict';

var dbm;
var type;
var seed;

/**
  * We receive the dbmigrate dependency from dbmigrate initially.
  * This enables us to not have to rely on NODE_PATH.
  */
exports.setup = function(options, seedLink) {
  dbm = options.dbmigrate;
  type = dbm.dataType;
  seed = seedLink;
};

exports.up = function (db) {
  return db.insert("candidates", {
    "candidate" : "visualvm", 
    "default" : "1.3.9", 
    "description" : "VisualVM is a tool that provides a visual interface for viewing detailed information about Java applications while they are running on a Java Virtual Machine.", 
    "name" : "VisualVM",
    "websiteUrl" : "https://visualvm.github.io/", 
    "distribution" : "UNIVERSAL" 
  }).then(
    function(result) {
      db.insert("versions", {
        "candidate" : "visualvm", 
        "version" : "1.3.9", 
        "url" : "https://github.com/visualvm/visualvm.src/releases/download/1.3.9/visualvm_139.zip", 
        "platform" : "UNIVERSAL"
      });
    },
    function(err) {
      return;
    }
  );
};

exports.down = function(db) {
  return null;
};

exports._meta = {
  "version": 1
};