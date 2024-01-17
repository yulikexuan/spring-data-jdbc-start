# Spring Transaction Example

## Testing Commands

### List All Accounts
- ``` curl -v -w '\nStatus: %{http_code}\nTotal: %{time_total} s\n' GET -H "Content-Type: application/json" http://localhost:8086/accounts ```

### Find Account by Id
- ``` curl -v -w '\nStatus: %{http_code}\nTotal: %{time_total} s\n' GET -H "Content-Type: application/json" http://localhost:8086/accounts/2 ```

### Find Accounts by Name 
- ``` curl -v -w '\nStatus: %{http_code}\nTotal: %{time_total} s\n' GET -H "Content-Type: application/json" http://localhost:8086/accounts?name=Helen%20Down ```
- ``` curl -v -w '\nStatus: %{http_code}\nTotal: %{time_total} s\n' GET -H "Content-Type: application/json" http://localhost:8086/accounts?name=Peter%20Read ```

### Find Account by Incorrect Id
- ``` curl -v -w '\nStatus: %{http_code}\nTotal: %{time_total} s\n' GET -H "Content-Type: application/json" http://localhost:8086/accounts/1234567 ```

### Transfer Money between Two Accounts
- ``` curl -v -w '\nStatus: %{http_code}\nTotal: %{time_total} s\n' POST -H "Content-Type: application/json" -d '{ "senderAccountId": 1, "receiverAccountId": 2, "amount": 10000 }' http://localhost:8086/accounts/trans ```