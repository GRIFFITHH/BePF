package com.tis1.bepf.project;

import java.util.*;

public class MemoryProjectRepository implements ProjectRepository{

    private static Map<Long, Project> store = new HashMap<>();

    @Override
    public void save(Project project) {
        store.put(project.getId(), project);
    }

    @Override
    public Optional<Project> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Project> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public Optional<Project> findByStack(String stack) {
        return store.values().stream()
                .filter(member -> member.getStack().equals(stack))
                .findAny();
    }

    @Override
    public Optional<Project> findByRegion(String region) {
        return store.values().stream()
                .filter(member -> member.getRegion().equals(region))
                .findAny();
    }

    @Override
    public List<Project> findAll() {
        return new ArrayList<>(store.values());
    }
}
