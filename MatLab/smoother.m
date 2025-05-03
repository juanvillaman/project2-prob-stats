% Paste this code into the MatLab Command Window if having trouble running it. It should work perfectfly
data = readmatrix('Salter.csv');
x = data(:, 1);
y = data(:, 2);

smooths = input("How many times do you want the data smooothed?: ");

smoothedY = y;
for i = 1:smooths
  smoothedY = movmean(smoothedY, 3);
end

smoothedData = [x, smoothedY];
writematrix(smoothedData, 'Smoother.csv');

disp('Smoothed data saved to Smoother.csv');
