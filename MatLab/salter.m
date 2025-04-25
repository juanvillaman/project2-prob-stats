% Paste this code into the MatLab Command Window if having trouble running it. It should work perfectfly
data = readmatrix('quadraticPlot.csv');
x = data(:, 1);
y = data(:, 2);

minVal = 1;
maxVal = 5;

noise = randi([minVal, maxVal], size(y));
signs = randi([0, 1], size(y)) * 2 - 1;
saltedY = y + noise .* signs;

saltedData = [x, saltedY];
writematrix(saltedData, 'Salter.csv');

disp('Salted data saved to Salter.csv');
