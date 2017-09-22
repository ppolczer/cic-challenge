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

*Note: Departments with 0 emissions are ignored*

## Response(s)

The response is represented as an array of JSON objects. A response object contains the following fields:

##### "department" (String):
City and County of San Francisco department name

##### "sourceType" (String):
Fuel type such as biodiesel, building propane, compressed natural gas (CNG), gasoline, diesel, and propane (vehicle); facility energy type such as electricity, natural gas and steam; and wastewater emission type such as wastewater combustion, wastewater effluent, and wastewater process.

##### "emissions" (double):
Total GHG emissions accounted for in metric tons of carbon dioxide equivalents (mtCO2e)
