package com.flipkart.flipomania.services;

import com.flipkart.flipomania.representations.ShortListed;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by :- Shiv Pratap Singh Parmar
 * Created on :- 6/6/15.
 */
public class Selector {
    int student_preference[][];
    int number_of_students, number_of_projects;
    HashMap<String, Integer> project;
    String studentIndex[], projectIndex[];
    List<List<String>> studentPreferences;

    public Map<String, List<String>> execute(final ShortListed shortListed) throws IOException {
        number_of_students = shortListed.getInputData().size();
        number_of_projects = shortListed.getActiveProjects().size();
        student_preference = new int[number_of_students + 1][number_of_projects + 1];
        studentIndex = new String[number_of_students + 1];
        projectIndex = new String[number_of_projects + 1];
        studentPreferences = new ArrayList<>();
        int i = 1;
        for (Map.Entry<String, List<String>> entry : shortListed.getInputData().entrySet()) {
            studentIndex[i] = entry.getKey();
            studentPreferences.add(entry.getValue());//0-indexed
            i++;
        }
        makeTable(shortListed.getActiveProjects());
        Map<String, List<String>> answer = new HashMap<>();
        for (i = 1; i <= number_of_projects; i++)
            answer.put(projectIndex[i], get_shortList(shortListed.getRoundNo(), i));
        return answer;
    }

    private void makeTable(List<String> activeProjects) {
        project = new HashMap<String, Integer>();
        int i, j;
        for (i = 1; i <= activeProjects.size(); i++) {
            project.put(activeProjects.get(i - 1), i);
            projectIndex[i] = activeProjects.get(i - 1);
        }
        for (i = 1; i <= number_of_students; i++) {
            for (j = 1; j <= number_of_projects; j++) {
                student_preference[i][project.get(studentPreferences.get(i - 1).get(j - 1))] = j;
            }
        }
    }


    List<String> get_shortList(int round, int project) throws IOException {
        List<String> result = new ArrayList<String>();
        int i, n = 0;//number of available choices
        int choices[] = new int[number_of_students + 1];
        for (i = 1; i <= number_of_students; i++)
            if (student_preference[i][project] == round) {
                choices[i] = 1;
                n++;
            }
        for (i = 1; i <= number_of_students; i++)
            if (choices[i] == 1) {
                result.add(studentIndex[i]);
            }
        return result;
    }
}
