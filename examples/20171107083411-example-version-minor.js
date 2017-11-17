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
  return db.insert("versions", {
    "candidate" : "visualvm", 
    "version" : "1.3.10", 
    "url" : "https://github.com/visualvm/visualvm.src/releases/download/1.3.10/visualvm_1310.zip", 
    "platform" : "UNIVERSAL"
  });
};

exports.down = function(db) {
  return null;
};

exports._meta = {
  "version": 1
};