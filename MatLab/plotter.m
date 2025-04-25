% This is my Plotter using MatLab. It takes the inputs for the quadratic equation ax^2 + bx + c
% Paste this code into the MatLab Command Window if having trouble running it. It should work perfectfly

a = input('Enter coefficient a: ');
b = input('Enter coefficient b: ');
c = input('Enter coefficient c: ');

x = -20:1:20; % X is calculated from -20 to 20, incrementing by 1
y = a * x.^2 + b * x + c; % Y is calculated using the quadratic equation with increasing X values

data = [x', y'];
writematrix(data, 'Plotter.csv'); % Writes the data to a CSV file

disp('Plotter data saved to Plotter.csv'); % Confirmation Message for CSV file creation