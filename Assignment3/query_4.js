printjson(db.people.find({ $expr: { $and: [ { $gt: [ { $toDouble: "$weight" }, 68 ] } , { $lt: [ { $toDouble: "$weight" }, 71.5] }]}}).toArray())