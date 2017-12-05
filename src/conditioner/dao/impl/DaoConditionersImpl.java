package conditioner.dao.impl;

import conditioner.dao.DaoConditioners;
import conditioner.data.Database;
import conditioner.model.Conditioners;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DaoConditionersImpl implements DaoConditioners {
    private static List<Conditioners<String>> list = Database.getAllConditions();
    private static Scanner scn = new Scanner(System.in);


    @Override
    public void show() {


        System.out.println("Список кондиционеров" + " [" + list.size() + "]");
        System.out.println("Для просмотра сатуса кондиционеров надать          [1]");
        System.out.println("Для включения кондиционеров нажать                 [2]" + "  " +
                "включенных кондиционеров  " + "[" + workConditioners() + "]");
        System.out.println("Для выключения кондиционера нажать                 [3]" + " " +
                " выключенных кондиционеров " + "[" + notWorkConditioners() + "]");
        System.out.println("Выбрать кондиционеры для выбора температуры        [4]" + "  " +
                "для выбора доступно " + "      [" + workConditioners() + "]" + " кондишенов(a)");
        System.out.println("Для выхода нажать                                  [5]");

        if (scn.hasNextInt()) {
            int value = scn.nextInt();
            switch (value) {
                case 1:
                    getStatusConditioners();
                    break;

                case 2:
                    System.out.println("Выбери количество кондишенов для включения");
                    if (scn.hasNextInt()) {
                        int b = 0;
                        int quantity = scn.nextInt();
                        System.out.println("Вводи индексы элемментов");
                        while (b < quantity) {
                            int elem = scn.nextInt();
                            turnOn(elem);
                            b++;
                        }
                    }
                    break;

                case 3:
                    System.out.println("Выбери количество кондишенов для включения");
                    if (scn.hasNextInt()) {
                        int b = 0;
                        int quantity = scn.nextInt();
                        System.out.println("Вводи индексы элемментов");
                        while (b < quantity) {
                            int elem = scn.nextInt();
                            turnOff(elem);
                            b++;
                        }
                    }
                    break;

                case 4:
                    System.out.println("Установи температуру для этих кондиционеров ");
                    int a = 0;
                    int c = 0;
                    ArrayList<Integer> index = new ArrayList<>();
                    for (Conditioners<String> elem : list) {
                        if (elem.getOnOff().contains("[On]")) {
                            index.add(list.indexOf(elem));
                            System.out.printf("%-15s\n", elem.getName());
                            a++;
                        }
                    }
                    System.out.println("Установка температуры для кондиционеров с индексом "+ "["+index+"]");
                    ArrayList<Integer> temp = new ArrayList<>();
                    while (c < a) {
                        if (scn.hasNextInt()) {
                            int value2 = scn.nextInt();
                            temp.add(value2);
                        }
                        c++;
                    }
                    setTemperature(index,temp);

                    break;

                case 5:
                    System.exit(1);
                    break;
                default:
                    break;
            }
        }
        choose();
        scn.close();
    }

    private void choose() {
        System.out.println("Для  выхода в главное мению нажать  [1]");
        if (scn.hasNextInt()) {
            int value = scn.nextInt();
            if (value == 1) {
                show();
            }
        }
    }

    private int workConditioners() {
        int work = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getOnOff().contains("[On]")) {
                work++;
            }
        }
        return work;
    }

    private int notWorkConditioners() {
        int notWork = 0;
        for (Conditioners<String> aList : list) {
            if (aList.getOnOff().contains("[Off]")) {
                notWork++;
            }
        }
        return notWork;
    }

    @Override
    public void getStatusConditioners() {
        for (Conditioners elem : list) {
            System.out.printf("%-15s%10s%5d\n", elem.getName(), elem.getOnOff(), elem.getTemp());
        }
    }

    @Override
    public List<Conditioners<String>> setTemperature(ArrayList<Integer> index, ArrayList<Integer> temp) {
        for (int i = 0; i < index.size(); i++) {
            list.get(index.get(i)).setTemp(temp.get(i));
        }
        return list;
    }


    @Override
    public List<Conditioners<String>> turnOn(int indexOn) {
        list.get(indexOn).setOnOff("[On]");
        return list;
    }

    @Override
    public List<Conditioners<String>> turnOff(int indexOff) {
        list.get(indexOff).setOnOff("[Off]");
        list.get(indexOff).setTemp(0);
        return list;
    }
}