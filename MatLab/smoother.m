data = readmatrix('saltedGraph.csv');
x = data(:, 1);
y = data(:, 2);

smoothedY = movmean(y, 3);
smoothedData = [x, smoothedY];
writematrix(smoothedData, 'Smoother.csv');

disp('Smoothed data saved to Smoother.csv');
