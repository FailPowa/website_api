package com.website.api.Controller;

import org.springframework.stereotype.Controller;
import com.website.api.Entity.Status;
import com.website.api.Repository.StatusRepository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
@RequestMapping(path="/status")
public class StatusController {
  @Autowired
  private StatusRepository statusRepository;

  private static final ArrayList<String> availableStatus =
      new ArrayList<String>(Arrays.asList("positive", "negative", "active", "intermediary"));
  private static final ArrayList<String> availableColors =
      new ArrayList<String>(Arrays.asList("#66d38f", "#ed524c", "#1294fc", "#f6aa28"));
  private static final ArrayList<String> availableTexts =
      new ArrayList<String>(Arrays.asList("Open to work", "Mission en cours", "A l'écoute du marché", "Occupé par un projet"));

  @CrossOrigin
  @GetMapping
  public @ResponseBody Optional<Status> getStatus() {
    return statusRepository.findById(1);
  }

  @PutMapping(path="/{value}")
  public @ResponseBody Optional<Status> setStatus(@PathVariable String value) {
    if(availableStatus.contains(value)) {
      return statusRepository.findById(1).map(status -> {
        status.setValue(value);
        status.setColor(availableColors.get(availableStatus.indexOf(value)));
        status.setText(availableTexts.get(availableStatus.indexOf(value)));
        return statusRepository.save(status);
      });
    }
    return Optional.ofNullable(new Status());
  }
}