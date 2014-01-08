CounterfeitBallDemo
====================


Import
--------------------------------------
1. Clone the project to your local
2. Run it and read it in your favorite way. It is at hand for Eclipse users.


How to read this demo?
--------------------------------------
`TestMain.java` is the main file with some commments in it so that you could understand it more easily. There are 4 parts `TestMainJava` achieves:

1. Construct a TernaryDecisionTree object manually according to the sample dabate on: http://bit.ly/1iV0zpP 

  Since it is a demo, we construct the object manually. Actually you need to program your own code to generate your  TernaryDecisionTree Object, efficiently and correctly.

2. Create a Gson instance to convert TernaryDecisionTree Java Object into JSON String.  [Gson](http://code.google.com/p/google-gson/) is a Java library that can be used to convert Java Objects into their JSON representation. It can also be used to convert a JSON string to an equivalent Java object. 

3. We convert the JSON String generated in part2 to a TernaryDecisionTree Java Object back.

4. It is the part where you should verify whether the restored TernaryDecisionTree meet requirements in your mind.


For real debates
--------------------------------------
1. If you are a verifier for CounterfeitBall(n,q), you construct your TernaryDecisionTree and make it into JSON String. Then you give your opposite that String.
2. If you are a falsifier, after receiving the verifier's JSON String, you convert it back to a TernaryDecisionTree Object and do your verification.
  
  
  
<br>
<br>
Happy Debating
