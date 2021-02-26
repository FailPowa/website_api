package com.website.api.Controller;

import org.springframework.stereotype.Controller;
import com.website.api.Repository.ProjectRepository;
import com.website.api.Request.ProjectRequest;
import com.website.api.Entity.Project;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequestMapping(path="/project")
public class ProjectController {
  @Autowired
  private ProjectRepository projectRepository;

  @GetMapping(path="/all")
  public @ResponseBody Iterable<Project> getAll() {
    return projectRepository.findAll();
  }

  @GetMapping(path="/{id}")
  public @ResponseBody Optional<Project> getById(@PathVariable Integer id) {
      return projectRepository.findById(id);
  }

  @PostMapping(path="/add")
  public @ResponseBody String addProject(@RequestBody ProjectRequest request) {
      Project p = new Project();
      p.setName(request.getName());
      p.setDescription(request.getDescription());
      p.setIcon(request.getIcon());
      p.setGem(request.getGem());
      p.setColor(request.getColor());
      p.setGithub(request.getGithub());
      p.setUrl(request.getUrl());
      projectRepository.save(p);

      return "Saved !";
  }
}