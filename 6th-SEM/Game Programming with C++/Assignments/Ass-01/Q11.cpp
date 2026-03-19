#include <iostream>
using namespace std;

class Employee
{
private:
    string name, profession, address, pan;
    int age;
    double salary;
    double taxableIncome;
    double tax;

public:
    // Default constructor
    Employee()
    {
        name = "NA";
        profession = "NA";
        address = "NA";
        pan = "NA";
        age = 0;
        salary = 0;
        taxableIncome = 0;
        tax = 0;
    }

    // Parameterized constructor with default arguments
    Employee(string n = "NA", int a = 0, string p = "NA", double s = 0,
             string addr = "NA", string panNo = "NA")
    {
        name = n;
        age = a;
        profession = p;
        salary = s;
        address = addr;
        pan = panNo;
    }

    void calculateTax()
    {
        double standardDeduction = 75000;
        taxableIncome = salary - standardDeduction;

        if (taxableIncome <= 300000)
            tax = 0;
        else if (taxableIncome <= 700000)
            tax = 0.05 * (taxableIncome - 300000);
        else if (taxableIncome <= 1000000)
            tax = 20000 + 0.10 * (taxableIncome - 700000);
        else if (taxableIncome <= 1200000)
            tax = 50000 + 0.15 * (taxableIncome - 1000000);
        else if (taxableIncome <= 1500000)
            tax = 80000 + 0.20 * (taxableIncome - 1200000);
        else
            tax = 140000 + 0.30 * (taxableIncome - 1500000);

        // Rebate if income <= 7 lakhs
        if (taxableIncome <= 700000)
            tax = 0;

        // Health cess 4%
        tax = tax + (tax * 0.04);
    }

    void printTax()
    {
        cout << "\nEmployee Name: " << name << endl;
        cout << "Age: " << age << endl;
        cout << "Profession: " << profession << endl;
        cout << "Address: " << address << endl;
        cout << "PAN: " << pan << endl;

        cout << "\nSalary: Rs. " << salary << endl;
        cout << "Standard Deduction: Rs. 75000" << endl;
        cout << "Taxable Income: Rs. " << taxableIncome << endl;
        cout << "Total Tax Payable: Rs. " << tax << endl;
    }
};

int main()
{
    Employee e("Satya Brata Rout", 35, "Asst. Prof.", 1275000,
               "Bhubaneswar", "XAB8450A");

    e.calculateTax();
    e.printTax();

    return 0;
}