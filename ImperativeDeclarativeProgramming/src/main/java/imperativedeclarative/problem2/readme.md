We have an object with the properties from the table<br>
We need to check the conditions from the table, <u>in that exact order</u><br>
The "algorithm" will stop at the first condition that returns false<br>
If all conditions returns true (the object is eligible), we will return ELIGIBLE<br>
If one of the conditions is false (we will stop) we will return the value from column "When false"
If a condition "Has boolean flag", that condition will be checked only if the flag is set to true 

<br><br>
<table>
<tr><td><b>Field</b></td><td><b>Condition</b></td><td>When false</td><td><b>Has boolean flag</b></td>
<tr><td>productId</td><td>is greater than 1234</td><td>NOT_ELIGIBLE</td><td></td>
<tr><td>category</td><td>is equal to A</td><td>PARTIALLY_ELIGIBLE</td><td>X</td>
<tr><td>amount</td><td>is between [200 - 300]</td><td>NOT_ELIGIBLE</td><td>X</td>
<tr><td>isAvailable</td><td>is true</td><td>PARTIALLY_ELIGIBLE</td><td></td>
<tr><td>expirationDate</td><td>in the future</td><td>NOT_ELIGIBLE</td><td></td>
<tr><td>deliveryDate</td><td>is before expirationDate</td><td>NOT_ELIGIBLE</td><td></td>
<tr><td>taxPercentage</td><td>is not 0.0</td><td>PARTIALLY_ELIGIBLE</td><td>X</td>
</table>
