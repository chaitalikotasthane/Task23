const functions = require('firebase-functions');
exports.onMessageUpdate=functions.database
.ref('/Users/{userid}')
.onCreate((snapshot,context)=>{
  const after=snapshot.val()
  console.log(after.Name)
  var firstPlayerRef = snapshot.ref("/Users/{userid}").limitToFirst(1);
  firstPlayerRef.on("value", function(data) {
   data.val()=null
   return null
}, function (error) {
   console.log("Error: " + error.code);
});



})

// // Create and Deploy Your First Cloud Functions
// // https://firebase.google.com/docs/functions/write-firebase-functions
//
// exports.helloWorld = functions.https.onRequest((request, response) => {
//  response.send("Hello from Firebase!");
// });
//ref.orderByChild("weight").limitToLast(2).on("child_added", function(snapshot) {
  // This callback will be triggered exactly two times, unless there are
  // fewer than two dinosaurs stored in the Database. It will also get fired
  // for every new, heavier dinosaur that gets added to the data set.
//  console.log(snapshot.key);
//});
