printjson(
db.people.aggregate(
   [  { $unwind: "$credit" },
{ $match : { sex : "Female", nationality : "Poland" }},
  {
       $group:
         {
           _id: "$credit.currency",
           avgBalance: { $avg:{$toDouble: "$credit.balance" }},
           total: { $sum:{$toDouble: "$credit.balance" }}
         }
     }
   ]
).toArray())
