package newgame.states;

import newgame.game.Drawable;
import newgame.game.Updatable;
import newgame.input.RespondsToInput;

public interface State extends RespondsToInput, Drawable, Updatable {}
