# CIC-Challenge

A REST service application using Spring Boot and Jackson, implemented for the CIC-Challenge.

The service can be used to query the CO2 emissions of public buildings in San Francisco. The data is queried from https://data.sfgov.org/Energy-and-Environment/San-Francisco-Municipal-Greenhouse-Gas-Inventory/pxac-sadh.

## USAGE

Get all emissions:

```
http://host:port/emissions
```

To get the emissions of a specific department, use the department parameter:
```
http://host:port/emissions?department=311%20Customer%20Service%20Center
```

