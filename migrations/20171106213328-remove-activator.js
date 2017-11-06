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

exports.up = function(db) {
  db._run('remove', 'versions', {"candidate": "activator", "version": "1.3.9"});
  db._run('remove', 'versions', {"candidate": "activator", "version": "1.3.10"});
  return db._run('remove', 'candidates', {"candidate": "activator"});
};

exports.down = function(db) {
  return null;
};

exports._meta = {
  "version": 1
};
