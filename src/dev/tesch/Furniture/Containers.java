package dev.tesch.Furniture;

import dev.tesch.save.LoadFromFile;

import java.util.*;

public class Containers {

    // HashMap the containers are stored in
    public HashMap<Integer, Container> containersMap = new HashMap<>();

    public Containers() {

        LoadFromFile.LoadContainersFromFile(containersMap);
//        ));
    }
}
