% Paste this code into the MatLab Command Window if having trouble running it. It should work perfectfly
data = readmatrix('Plotter.csv');
x = data(:, 1);
y = data(:, 2);

minVal = 1;
maxVal = 10;

noise = randi([minVal, maxVal], size(y));
randomSign = randi([0, 1], size(y));
randomSign(randomSign == 0) = -1;

saltedY = y + noise .* randomSign;
saltedData = [x, saltedY];
writematrix(saltedData, 'Salter.csv');

disp('Salted data saved to Salter.csv');
