import Card from "@mui/material/Card";
import CardActions from "@mui/material/CardActions";
import CardContent from "@mui/material/CardContent";
import CardMedia from "@mui/material/CardMedia";
import Button from "@mui/material/Button";
import Typography from "@mui/material/Typography";
import { Link } from "react-router-dom";

import banner from "../assets/banner.png";

export default function MealCardSummary() {
  return (
    <Card sx={{ width: "100%" }}>
      <CardMedia sx={{ height: 140 }} image={banner} title="green iguana" />
      <CardContent>
        <Typography gutterBottom variant="h5" component="div">
          Nom du menu
        </Typography>
        <Typography variant="body2" sx={{ color: "text.secondary" }}>
          Time
        </Typography>
      </CardContent>
      <CardActions sx={{ justifyContent: "flex-end" }}>
        <Button variant="contained" component={Link} to="/meal/{id}">
          Voir le détail
        </Button>
      </CardActions>
    </Card>
  );
}
