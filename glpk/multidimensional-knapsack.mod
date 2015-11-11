set items;
set dimensions;

param capacity { d in dimensions };
param itemValue { i in items };
param itemSizeInDimension { i in items, d in dimensions };

var x { i in items } binary;

maximize profit: sum {i in items } x[i] * itemValue[i];

s.t. dimension_limit {d in dimensions}:
	(sum {i in items } itemSizeInDimension[i,d] * x[i])  <= capacity[d];

end;
