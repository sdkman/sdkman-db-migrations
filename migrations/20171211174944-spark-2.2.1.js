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
    "candidate" : "spark", 
    "version" : "2.2.1", 
    "url" : "http://www.mirrorservice.org/sites/ftp.apache.org/spark/spark-2.2.1/spark-2.2.1-bin-hadoop2.7.tgz", 
    "platform" : "UNIVERSAL"
  }).then(
    function(result) {
      db._run("update", "candidates", {
        "query": {"candidate" : "spark"},
        "update": {$set: {default: '2.2.1'}}
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
