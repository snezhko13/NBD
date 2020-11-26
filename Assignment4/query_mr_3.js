var q3 = function() {
emit(this.job,1);
};
    var r = function(key, v) {
return null;
};
    var result = {
  out:"job_list" 
};
db.people.mapReduce(q3,r,result)
printjson(db.job_list.find({},{id:1}).toArray())
