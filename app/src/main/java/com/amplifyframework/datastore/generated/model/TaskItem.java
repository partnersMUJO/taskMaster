package com.amplifyframework.datastore.generated.model;

import static com.amplifyframework.core.model.query.predicate.QueryField.field;

import androidx.core.util.ObjectsCompat;

import com.amplifyframework.core.model.Model;
import com.amplifyframework.core.model.annotations.BelongsTo;
import com.amplifyframework.core.model.annotations.Index;
import com.amplifyframework.core.model.annotations.ModelConfig;
import com.amplifyframework.core.model.annotations.ModelField;
import com.amplifyframework.core.model.query.predicate.QueryField;

import java.util.Objects;
import java.util.UUID;

/** This is an auto generated class representing the TaskItem type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "TaskItems")
@Index(name = "tasks", fields = {"teamId"})
public final class TaskItem implements Model {
  public static final QueryField ID = field("id");
  public static final QueryField TITLE = field("title");
  public static final QueryField BODY = field("body");
  public static final QueryField TEAM = field("teamId");
  public static final QueryField STATE = field("state");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="String", isRequired = true) String title;
  private final @ModelField(targetType="String", isRequired = true) String body;
  private final @ModelField(targetType="Team", isRequired = true) @BelongsTo(targetName = "teamId", type = Team.class) Team team;
  private final @ModelField(targetType="String") String state;
  public String getId() {
      return id;
  }
  
  public String getTitle() {
      return title;
  }
  
  public String getBody() {
      return body;
  }
  
  public Team getTeam() {
      return team;
  }
  
  public String getState() {
      return state;
  }
  
  private TaskItem(String id, String title, String body, Team team, String state) {
    this.id = id;
    this.title = title;
    this.body = body;
    this.team = team;
    this.state = state;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      TaskItem taskItem = (TaskItem) obj;
      return ObjectsCompat.equals(getId(), taskItem.getId()) &&
              ObjectsCompat.equals(getTitle(), taskItem.getTitle()) &&
              ObjectsCompat.equals(getBody(), taskItem.getBody()) &&
              ObjectsCompat.equals(getTeam(), taskItem.getTeam()) &&
              ObjectsCompat.equals(getState(), taskItem.getState());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getTitle())
      .append(getBody())
      .append(getTeam())
      .append(getState())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("TaskItem {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("title=" + String.valueOf(getTitle()) + ", ")
      .append("body=" + String.valueOf(getBody()) + ", ")
      .append("team=" + String.valueOf(getTeam()) + ", ")
      .append("state=" + String.valueOf(getState()))
      .append("}")
      .toString();
  }
  
  public static TitleStep builder() {
      return new Builder();
  }
  
  /** 
   * WARNING: This method should not be used to build an instance of this object for a CREATE mutation.
   * This is a convenience method to return an instance of the object with only its ID populated
   * to be used in the context of a parameter in a delete mutation or referencing a foreign key
   * in a relationship.
   * @param id the id of the existing item this instance will represent
   * @return an instance of this model with only ID populated
   * @throws IllegalArgumentException Checks that ID is in the proper format
   */
  public static TaskItem justId(String id) {
    try {
      UUID.fromString(id); // Check that ID is in the UUID format - if not an exception is thrown
    } catch (Exception exception) {
      throw new IllegalArgumentException(
              "Model IDs must be unique in the format of UUID. This method is for creating instances " +
              "of an existing object with only its ID field for sending as a mutation parameter. When " +
              "creating a new object, use the standard builder method and leave the ID field blank."
      );
    }
    return new TaskItem(
      id,
      null,
      null,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      title,
      body,
      team,
      state);
  }
  public interface TitleStep {
    BodyStep title(String title);
  }
  

  public interface BodyStep {
    TeamStep body(String body);
  }
  

  public interface TeamStep {
    BuildStep team(Team team);
  }
  

  public interface BuildStep {
    TaskItem build();
    BuildStep id(String id) throws IllegalArgumentException;
    BuildStep state(String state);
  }
  

  public static class Builder implements TitleStep, BodyStep, TeamStep, BuildStep {
    private String id;
    private String title;
    private String body;
    private Team team;
    private String state;
    @Override
     public TaskItem build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new TaskItem(
          id,
          title,
          body,
          team,
          state);
    }
    
    @Override
     public BodyStep title(String title) {
        Objects.requireNonNull(title);
        this.title = title;
        return this;
    }
    
    @Override
     public TeamStep body(String body) {
        Objects.requireNonNull(body);
        this.body = body;
        return this;
    }
    
    @Override
     public BuildStep team(Team team) {
        Objects.requireNonNull(team);
        this.team = team;
        return this;
    }
    
    @Override
     public BuildStep state(String state) {
        this.state = state;
        return this;
    }
    
    /** 
     * WARNING: Do not set ID when creating a new object. Leave this blank and one will be auto generated for you.
     * This should only be set when referring to an already existing object.
     * @param id id
     * @return Current Builder instance, for fluent method chaining
     * @throws IllegalArgumentException Checks that ID is in the proper format
     */
    public BuildStep id(String id) throws IllegalArgumentException {
        this.id = id;
        
        try {
            UUID.fromString(id); // Check that ID is in the UUID format - if not an exception is thrown
        } catch (Exception exception) {
          throw new IllegalArgumentException("Model IDs must be unique in the format of UUID.",
                    exception);
        }
        
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(String id, String title, String body, Team team, String state) {
      super.id(id);
      super.title(title)
        .body(body)
        .team(team)
        .state(state);
    }
    
    @Override
     public CopyOfBuilder title(String title) {
      return (CopyOfBuilder) super.title(title);
    }
    
    @Override
     public CopyOfBuilder body(String body) {
      return (CopyOfBuilder) super.body(body);
    }
    
    @Override
     public CopyOfBuilder team(Team team) {
      return (CopyOfBuilder) super.team(team);
    }
    
    @Override
     public CopyOfBuilder state(String state) {
      return (CopyOfBuilder) super.state(state);
    }
  }
  
}
