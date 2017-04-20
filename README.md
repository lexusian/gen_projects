SETUP:

1. Clone the project using any git client tool by using the GIT url.
2. Use Eclipse IDE and import the project.
3. To run/test the project run the TestShoppingCart.java/TestRunner.java as JUNIT in eclipse.
4. If no IDE, just run the in commandline the the following:
java -cp c:\gen_projects\bin;org.hamcrest.core_1.3.0.v201303031735.jar;junit.jar org.junit.runner.JUnitCore TestShopp
ingCart

Note: assuming that you checkout the project in drive c: (windows) and org.hamcrest.core_1.3.0.v201303031735.jar and junit.jar belong to the classpath.

Additional Notes:
File:
pricing.properties files is where you define  price as shown below:
ult_small=24.9
ult_medium=29.9
ult_large=44.9
1gb=9.9
ult_small_disc_count=3
ult_medium_disc_count=0
ult_large_disc_count=3
1gb_disc_count=0
promo_discount=.10

This content is configurable for each product, in addition you can control the promotions for example if you need to change the rule for:

"A 3 for 2 deal on Unlimited 1GB Sims. So for example, if you buy 3 Unlimited 1GB Sims, you will pay the price of 2 only for the first
month."
instead of buying 3 Unlimited 1gb sims to avail to pay only for two then you change it to 4 by simply changing the ult_small_disc_count field and set it to 4.




