a = input('Enter coefficient a: ');
b = input('Enter coefficient b: ');
c = input('Enter coefficient c: ');

x = -20:1:20;
y = a * x.^2 + b * x + c;

data = [x', y'];
writematrix(data, 'Plotter.csv');

disp('Plotter data saved to Plotter.csv');